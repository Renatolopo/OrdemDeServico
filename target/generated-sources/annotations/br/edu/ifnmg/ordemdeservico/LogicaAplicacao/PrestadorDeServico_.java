package br.edu.ifnmg.ordemdeservico.LogicaAplicacao;

import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Servico;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-08-17T09:03:03", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(PrestadorDeServico.class)
public class PrestadorDeServico_ { 

    public static volatile ListAttribute<PrestadorDeServico, Servico> servicos;
    public static volatile SingularAttribute<PrestadorDeServico, Long> id;
    public static volatile SingularAttribute<PrestadorDeServico, String> areaDeAtuacao;

}