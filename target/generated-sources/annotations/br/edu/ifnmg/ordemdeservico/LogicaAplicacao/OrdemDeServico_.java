package br.edu.ifnmg.ordemdeservico.LogicaAplicacao;

import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Cliente;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.FormaDePagamento;
import br.edu.ifnmg.ordemdeservico.LogicaAplicacao.Servico;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-09-06T10:41:58", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(OrdemDeServico.class)
public class OrdemDeServico_ { 

    public static volatile SingularAttribute<OrdemDeServico, Cliente> cliente;
    public static volatile ListAttribute<OrdemDeServico, Servico> servicos;
    public static volatile SingularAttribute<OrdemDeServico, Date> data;
    public static volatile SingularAttribute<OrdemDeServico, String> motivoDaChamada;
    public static volatile SingularAttribute<OrdemDeServico, Long> id;
    public static volatile SingularAttribute<OrdemDeServico, FormaDePagamento> formaDePagamento;
    public static volatile SingularAttribute<OrdemDeServico, BigDecimal> totalDoServico;
    public static volatile SingularAttribute<OrdemDeServico, Date> fimDoAtendimento;

}