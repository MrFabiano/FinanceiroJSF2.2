package com.projeto.financeiro.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ConsultaPessoaBean {

	private List<String> novas = new ArrayList<String>();
	
	@PostConstruct
	public void inicializar() {
		for (int i = 0; i < 20; i++) {
			novas.add("");
		}
	}

	public List<String> getNovas() {
		return novas;
	}
	
}