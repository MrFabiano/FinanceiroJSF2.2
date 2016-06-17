package repository;

import java.util.List;

import com.projeto.financeiro.model.Pessoa;

public interface Pessoas {
	
	public List<Pessoa> todas();
	public Pessoa porCodigo(Integer codigo);
	

}
