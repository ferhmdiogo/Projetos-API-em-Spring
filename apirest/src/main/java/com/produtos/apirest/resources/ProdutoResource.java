package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produtos;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista de produtos")
	public List<Produtos> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produtos/{id}")
	@ApiOperation(value="Retorna um produto")
	public Produtos listaProdutosUnico(@PathVariable(value="id") long id){
		return produtoRepository.findById(id);
		
	}
	
	@PostMapping("/produtos")
	@ApiOperation(value="Salva um novo produto")
	public Produtos salvaProduto(@RequestBody Produtos produtos) {
		return produtoRepository.save(produtos);
	}
	
	@DeleteMapping("/produtos")
	@ApiOperation(value="Exclui um produto")
	public void deletaProduto (@RequestBody Produtos produtos) {
		produtoRepository.delete(produtos);
		
	}
	
	@PutMapping("/produtos")
	@ApiOperation(value="Atualiza um produto")
	public Produtos atualizaProduto (@RequestBody Produtos produtos) {
		return produtoRepository.save(produtos);
		
	}

}
