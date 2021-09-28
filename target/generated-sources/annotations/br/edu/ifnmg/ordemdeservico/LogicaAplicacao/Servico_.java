package br.edu.ifnmg.ordemdeservico.LogicaAplicacao;

import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Item;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.PrestadorDeServico;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-09-28T09:08:50", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Servico.class)
public class Servico_ { 

    public static volatile ListAttribute<Servico, Item> itens;
    public static volatile SingularAttribute<Servico, String> observacao;
    public static volatile SingularAttribute<Servico, String> diagnostico;
    public static volatile SingularAttribute<Servico, String> resolucao;
    public static volatile SingularAttribute<Servico, PrestadorDeServico> prestadorDeServico;
    public static volatile SingularAttribute<Servico, Long> id;
    public static volatile SingularAttribute<Servico, String> descricao;
    public static volatile SingularAttribute<Servico, String> status;

}