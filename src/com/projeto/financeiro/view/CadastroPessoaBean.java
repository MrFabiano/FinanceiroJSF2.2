package com.projeto.financeiro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.projeto.financeiro.model.NovaPessoa;
import com.projeto.financeiro.model.RamoAtividade;
import com.projeto.financeiro.model.TipoPessoa;
import com.projeto.financeiro.util.HibernateUtil;

@ViewScoped
@ManagedBean
public class CadastroPessoaBean implements Serializable {
	
	private List<RamoAtividade> ramosAtividades = new ArrayList<RamoAtividade>();
	private NovaPessoa novas = new NovaPessoa();   
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
        Session session = HibernateUtil.getSession();
		
		this.ramosAtividades = session.createCriteria(RamoAtividade.class)
				.addOrder(Order.asc("descricao"))
				.list();
		
		session.close();
		
	}
	
	public void cadastrar() {
		 Session session = HibernateUtil.getSession();
	        Transaction trx = session.beginTransaction();
	        
	        session.merge(this.novas);
	        
	        trx.commit();
	        session.close();

			this.novas = new NovaPessoa();
		

		this.novas = new NovaPessoa();
		
		String msg = "Cadastro efetuado com sucesso!";
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
	public TipoPessoa[] getTiposPessoas() {
		return TipoPessoa.values();
	}

	public List<RamoAtividade> getRamosAtividades() {
		return ramosAtividades;
	}

	public NovaPessoa getNovas() {
		return novas;
	}

	




	
	
	
	
}

