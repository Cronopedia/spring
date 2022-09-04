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
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque tortor quam, luctus sed sodales a, fermentum at urna. Curabitur laoreet mi ut pellentesque iaculis. Nunc mollis tellus ac dolor varius, vel iaculis ex tempus.",
                    "JavaScript",
                    "https://static.todamateria.com.br/upload/an/oi/anoiteestreladaalua.jpg?auto_optimize=low"));

            PaginaRepository.add(new Pagina(
                    "titulo 2",
                    "desconhecido",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque tortor quam, luctus sed sodales a, fermentum at urna. Curabitur laoreet mi ut pellentesque iaculis. Nunc mollis tellus ac dolor varius, vel iaculis ex tempus.",
                    "Java",
                    "https://cdn.culturagenial.com/imagens/899px-grant-devolson-wood-american-gothic-cke.jpg?auto_optimize=low"));

            PaginaRepository.add(new Pagina(
                    "titulo 3",
                    "desconhecido",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque tortor quam, luctus sed sodales a, fermentum at urna. Curabitur laoreet mi ut pellentesque iaculis. Nunc mollis tellus ac dolor varius, vel iaculis ex tempus.",
                    "JavaScript",
                    "https://blog.leiloesbr.com.br/wp-content/uploads/2019/12/5840896-579x800.jpg"));

            PaginaRepository.add(new Pagina(
                    "titulo 4",
                    "desconhecido",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque tortor quam, luctus sed sodales a, fermentum at urna. Curabitur laoreet mi ut pellentesque iaculis. Nunc mollis tellus ac dolor varius, vel iaculis ex tempus.",
                    "Cogumelo",
                    "https://pm1.narvii.com/6245/926e9d9961a5b4ea70f6e18e50b94fe542b4ba9d_hq.jpg"));

            PaginaRepository.add(new Pagina(
                    "titulo 5",
                    "desconhecido",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque tortor quam, luctus sed sodales a, fermentum at urna. Curabitur laoreet mi ut pellentesque iaculis. Nunc mollis tellus ac dolor varius, vel iaculis ex tempus.",
                    "Roma",
                    "https://viagemeturismo.abril.com.br/wp-content/uploads/2017/05/moccca7a-com-brinco-pecc81rola.jpg?quality=70&strip=info"));
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
    // Funcionamento: navega pelo array de páginas e adiciona na lista aquelas que
    // foi verificado o relacionamento com o assunto
    public static List<Pagina> getByAssunto(String assunto) {
        return PaginaRepository.repo.paginas.stream().filter((e) -> e.relacionadaRX(assunto)).toList();
    }

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
            case 6:
                PaginaRepository.repo.paginas.stream().filter(
                        (elemento) -> elemento.getId() == id).toList().get(0).addImagem(conteudo);
                break;
            case 7:
                PaginaRepository.repo.paginas.stream().filter(
                        (elemento) -> elemento.getId() == id).toList().get(0).removeImagem(conteudo);
                break;
            default:
                break;
        }
    }

    // Removendo a página com o ID informado
    public static void delete(int id) {
        PaginaRepository.repo.paginas
                .remove(PaginaRepository.repo.paginas.stream().filter((e) -> e.getId() == id).toList().get(0));
    }
}
