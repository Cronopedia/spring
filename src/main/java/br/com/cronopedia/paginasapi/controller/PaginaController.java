package br.com.cronopedia.paginasapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cronopedia.paginasapi.model.Pagina;
import br.com.cronopedia.paginasapi.repository.PaginaRepository;

import java.util.List;

@CrossOrigin
@RestController
public class PaginaController {

    // Endpoints

    // Retorna todas as páginas
    @GetMapping("/paginas")
    public List<Pagina> allPages() {
        return PaginaRepository.all();
    }

    // Retorna uma página com o id solicitado no parâmetro
    @GetMapping("/paginas/id/{id}")
    public Pagina idPage(@PathVariable("id") int id) {
        return PaginaRepository.getById(id);
    }

    // Retorna todas as páginas com o assunto passado no parâmetro
    @GetMapping("/paginas/{assunto}")
    public List<Pagina> assuntoPage(@PathVariable("assunto") String assunto) {
        return PaginaRepository.getByAssunto(assunto);
    }

    // Adiciona uma nova página ao repository
    @PostMapping("/paginas/add")
    public void addPage(@RequestBody Pagina pagina) {
        PaginaRepository.add(pagina);
    }

    // Atualiza a página existente no repositório
    // (ATENÇÂO. Vai substituir a página com o id informado por aquela recebida no
    // JSON)
    // @PutMapping("/paginas/atualizar/{id}")
    // public void update(@RequestBody Pagina pagina) {
    // PaginaRepository.update(pagina);
    // }

    // Atualizando um campo de uma página
    @PutMapping("/paginas/atualizar/{campo}/{id}")
    public void update(@RequestBody String conteudo, @PathVariable("campo") int campo, @PathVariable("id") int id) {
        PaginaRepository.update(campo, conteudo, id);
    }

    // Deletando uma página
    @DeleteMapping("paginas/deletar/{id}")
    public void delete(@PathVariable("id") int id) {
        PaginaRepository.delete(id);
    }

    // Retorna todas as páginas
    @GetMapping("/paginas/daily")
    public int getPaginaDoDia() {
        return PaginaRepository.getPaginaDoDia();
    }
}
