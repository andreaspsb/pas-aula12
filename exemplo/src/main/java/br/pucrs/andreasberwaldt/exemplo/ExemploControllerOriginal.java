package br.pucrs.andreasberwaldt.exemplo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/biblioteca")
public class ExemploControllerOriginal {

    private List<Livro> livros;

    public ExemploControllerOriginal() {
        livros = List.of(
                new Livro(1, "1984", "George Orwell", 1949),
                new Livro(2, "To Kill a Mockingbird", "Harper Lee", 1960),
                new Livro(3, "The Great Gatsby", "F. Scott Fitzgerald", 1925));
    }

    @GetMapping("/")
    public String getMensagemInicial() {
        return "Aplicacao Spring-Boot funcionando!";
    }

    @GetMapping("/livros")
    public List<Livro> getLivros() {
        return livros;
    }

    @GetMapping("/titulos")
    public List<String> getTitulos() {
        return livros.stream()
                .map(Livro::getTitulo)
                .toList();
    }

    @GetMapping("/autores")
    public List<String> getAutores() {
        return livros.stream()
                .map(Livro::getAutor)
                .toList();
    }
}
