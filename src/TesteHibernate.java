import java.util.List;

import org.hibernate.Session;

import com.projeto.financeiro.model.Pessoa;
import com.projeto.financeiro.model.RamoAtividade;
import com.projeto.financeiro.util.HibernateUtil; 

public class TesteHibernate {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
		
		@SuppressWarnings("unchecked")
		List<Pessoa> pessoas = session.createCriteria(Pessoa.class).list(); 
		List<RamoAtividade> ramosAtividades = session.createCriteria(RamoAtividade.class).list();                                                       
		
		for(Pessoa p : pessoas){
			System.out.println(p.getCodigo() + " _ " + p.getNome());
		}
		
		
		session.close();

	}

}
