package todolist;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import todolist.Tarefatempo;
import todolist.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-09T23:52:47")
@StaticMetamodel(Tarefa.class)
public class Tarefa_ { 

    public static volatile SingularAttribute<Tarefa, BigInteger> temporealizado;
    public static volatile SingularAttribute<Tarefa, String> nome;
    public static volatile SingularAttribute<Tarefa, Integer> id;
    public static volatile CollectionAttribute<Tarefa, Tarefatempo> tarefatempoCollection;
    public static volatile SingularAttribute<Tarefa, Usuario> usuarioId;
    public static volatile SingularAttribute<Tarefa, BigInteger> tempoestimado;
    public static volatile SingularAttribute<Tarefa, String> descricao;

}