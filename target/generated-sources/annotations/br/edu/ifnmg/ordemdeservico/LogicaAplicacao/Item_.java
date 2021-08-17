package br.edu.ifnmg.ordemdeservico.LogicaAplicacao;

import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-08-17T09:03:03", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, String> marca;
    public static volatile SingularAttribute<Item, BigDecimal> custo;
    public static volatile SingularAttribute<Item, String> nome;
    public static volatile SingularAttribute<Item, Long> id;
    public static volatile SingularAttribute<Item, String> modelo;

}