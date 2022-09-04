package br.com.cronopedia.paginasapi.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.cronopedia.paginasapi.model.Pagina;

public class PaginaRepository {
    private static PaginaRepository repo;

    private ArrayList<Pagina> paginas;

    private PaginaRepository() {
        this.paginas = new ArrayList<>();
    }

    public static void init() {
        if (PaginaRepository.repo == null) {
            PaginaRepository.repo = new PaginaRepository();

            PaginaRepository.add(new Pagina(
                    "titulo 1",
                    "desconhecido",
                    "resumo 1",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque tortor quam, luctus sed sodales a, fermentum at urna. Curabitur laoreet mi ut pellentesque iaculis. Nunc mollis tellus ac dolor varius, vel iaculis ex tempus.",
                    "JavaScript"));

            PaginaRepository.add(new Pagina(
                    "titulo 2",
                    "desconhecido",
                    "resumo 2",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque tortor quam, luctus sed sodales a, fermentum at urna. Curabitur laoreet mi ut pellentesque iaculis. Nunc mollis tellus ac dolor varius, vel iaculis ex tempus.",
                    "Java"));

            PaginaRepository.add(new Pagina(
                    "titulo 3",
                    "desconhecido",
                    "resumo 3",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque tortor quam, luctus sed sodales a, fermentum at urna. Curabitur laoreet mi ut pellentesque iaculis. Nunc mollis tellus ac dolor varius, vel iaculis ex tempus.",
                    "JavaScript"));

            PaginaRepository.add(new Pagina(
                    "titulo 4",
                    "desconhecido",
                    "resumo 3",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque tortor quam, luctus sed sodales a, fermentum at urna. Curabitur laoreet mi ut pellentesque iaculis. Nunc mollis tellus ac dolor varius, vel iaculis ex tempus.",
                    "Cogumelo"));

            PaginaRepository.add(new Pagina(
                    "titulo 5",
                    "desconhecido",
                    "resumo 5",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque tortor quam, luctus sed sodales a, fermentum at urna. Curabitur laoreet mi ut pellentesque iaculis. Nunc mollis tellus ac dolor varius, vel iaculis ex tempus.",
                    "Roma"));
        }
    }

    // Adicionando uma nova página
    public static void add(Pagina pagina) {
        PaginaRepository.repo.paginas.add(pagina);
    }

    // Retornando todas as página
    public static List<Pagina> all() {
        return PaginaRepository.repo.paginas;
    }

    // Retornando a página com o ID solicitado
    public static Pagina getById(int id) {
        return PaginaRepository.repo.paginas.stream().filter((e) -> e.getId() == id).toList().get(0);
    }

    // Retornando as páginas que contém o assunto solicitado
    // Funcionamento: navega pelo array de páginas e adiciona a lista aquelas que
    // foi verificado o relacionamento com o assunto
    // (NOTA: O assunto deve se exatamente ao definido na instância)
    public static List<Pagina> getByAssunto(String assunto) {
        return PaginaRepository.repo.paginas.stream().filter((e) -> e.relacionadaRX(assunto)).toList();
    }

    // // Substituindo a página pela nova página
    // public static void update(Pagina pagina) {
    // int idToUp = pagina.getId();
    // int posicao =
    // PaginaRepository.repo.paginas.indexOf(PaginaRepository.repo.paginas.stream().filter(
    // (elemento) -> elemento.getId() == idToUp).toList().get(0));

    // PaginaRepository.repo.paginas.set(posicao, pagina);
    // }

    // Alterando uma informação na página
    public static void update(int campo, String conteudo, int id) {
        switch (campo) {
            case 1:
                PaginaRepository.repo.paginas.stream().filter(
                        (elemento) -> elemento.getId() == id).toList().get(0).setTitulo(conteudo);
                break;
            case 2:
                PaginaRepository.repo.paginas.stream().filter(
                        (elemento) -> elemento.getId() == id).toList().get(0).setResumo(conteudo);
                break;
            case 3:
                PaginaRepository.repo.paginas.stream().filter(
                        (elemento) -> elemento.getId() == id).toList().get(0).setConteudo(conteudo);
                break;
            case 4:
                PaginaRepository.repo.paginas.stream().filter(
                        (elemento) -> elemento.getId() == id).toList().get(0).addAssunto(conteudo);
                break;
            case 5:
                PaginaRepository.repo.paginas.stream().filter(
                        (elemento) -> elemento.getId() == id).toList().get(0).removeAssunto(conteudo);
                break;
            default:
                break;
        }
    }
}
