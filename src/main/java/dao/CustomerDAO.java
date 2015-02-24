package dao;

import java.util.List;

import model.Customer;

import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

/**
 * @author JBD
 *
 *         Ce DAO (Data Access Object) fournit les méthodes permettant de
 *         récuperer les objets entité référençant les clients et correspond
 *         donc à la couche Persistance (la seule qui peut agir sur la base de
 *         donnée). Afin de faciliter l'injection de dépendance grâce à Spring,
 *         on préferera définir une interface de type dont le nom est
 *         <nom_de_l'entité>DAO et dont l'implémentation sera
 *         <nom_de_l'entité>DAOImpl.
 * 
 *         Finalement, afin d'être utilisé avec Spring, un bean correspondant à
 *         cette interface se trouve dans CustomerBean.xml et est liée à son
 *         implémentation
 * 
 *         Cette classe étend GenericDAO, ce qui fournit à notre classe tout un
 *         panel d'action basique déjà implémentée (comme find(id), findAll(),
 *         save(customer), etc.)
 * 
 *         !!ATTENTION!! Les méthodes des classes DAO ne doivent être appelée
 *         que dans la couche Service ou dans la couche Persistance ! Il est
 *         formellement interdit d'appeler une méthode d'un DAO dans la couche
 *         présentation !!
 *
 */
@Repository("customerDao")
public interface CustomerDAO extends GenericDAO<Customer, Long> {

	/**
	 * Cette méthode permet de récuperer les clients dont le nom correspond avec
	 * celui fournit en paramètre. On récupère les données sous forme de List
	 * car name n'est pas unique et peut donc renvoyer de multiple instances.
	 * 
	 * @param name
	 * @return
	 */
	List<Customer> findByName(final String name);

	/**
	 * Cette méthode permet de récuperer les clients dont l'adresse correspond
	 * avec celle fournit en paramètre. On récupère les données sous forme de
	 * List car address n'est pas unique, la requête peut donc renvoyer de
	 * multiple instances.
	 * 
	 * @param address
	 * @return
	 */
	List<Customer> findByAddress(final String address);

	/**
	 * Cette méthode permet de récuperer les clients dont le nom et l'adresse
	 * correspondent avec ceux fournit en paramètre. On récupère les données
	 * sous forme de List car name et address ne sont pas uniques, la requête
	 * peut donc renvoyer de multiple instances
	 * 
	 * @param name
	 * @param address
	 * @return
	 */
	List<Customer> findByNameAndAddress(final String name, final String address);
}