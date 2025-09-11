package br.pucrs.andreasberwaldt.exemplo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/biblioteca")
public class ExemploController {
    private Acervo acervo;

    @Autowired
    public ExemploController(Acervo acervo) {
        this.acervo = acervo;
    }

    @GetMapping("/")
    public String getMensagemInicial() {
        return "Aplicacao Spring-Boot funcionando!";
    }

    @GetMapping("/livros")
    public List<Livro> getLivros() {
        return acervo.getLivros();
    }

    @GetMapping("/titulos")
    public List<String> getTitulos() {
        return acervo.getTitulos();
    }

    @GetMapping("/autores")
    public List<String> getAutores() {
        return acervo.getListaAutores();
    }

    @GetMapping("/livrosautor")
    public List<Livro> getLivrosDoAutor(@RequestParam(value = "autor") String autor) {
        return acervo.getLivrosDoAutor(autor);
    }

    @GetMapping("/livrosautorano/{autor}/ano/{ano}")
    public List<Livro> getLivrosDoAutor(@PathVariable(value = "autor") String autor,
            @PathVariable(value = "ano") int ano) {
        return acervo.getLivrosDoAutor(autor, ano);
    }

    @PostMapping("/novolivro")
    public boolean cadastraLivroNovo(@RequestBody final Livro livro) {
        return acervo.cadastraLivroNovo(livro);
    }

    @GetMapping("/livrotitulo/{titulo}")
    public ResponseEntity<Livro> getLivroTitulo(@PathVariable("titulo") String titulo) {
        Livro livro = acervo.getLivroTitulo(titulo);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(livro);
    }

    @DeleteMapping("/livrosano/{ano}")
    public boolean removerLivrosPorAno(@PathVariable("ano") int ano) {
        return acervo.removerLivrosAno(ano);
    }

    @PutMapping("/atualizalivro")
    public boolean alterarLivro(@RequestBody final Livro livro) {
        return acervo.alterarLivro(livro);
    }
}
