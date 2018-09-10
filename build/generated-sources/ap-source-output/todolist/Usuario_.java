package todolist;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import todolist.Tarefa;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-09T23:52:47")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> senha;
    public static volatile CollectionAttribute<Usuario, Tarefa> tarefaCollection;
    public static volatile SingularAttribute<Usuario, Integer> id;
    public static volatile SingularAttribute<Usuario, String> username;

}