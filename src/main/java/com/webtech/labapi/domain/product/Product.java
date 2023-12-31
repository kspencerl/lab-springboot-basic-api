package com.webtech.labapi.domain.product;

import com.webtech.labapi.domain.product.dto.RequestProduct;
import jakarta.persistence.*;
import lombok.*;


@Table(name="product")
@Entity(name="product")
@EqualsAndHashCode(of = "id") //coluna que identifica unicamente a nossa tabela = primarykey
@Getter
@Setter //notações do lombok geram métodos em tempo de execução. Sem necessidade de ficar criando métodos.
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.UUID) //@GeneratedValue => significa que esse valor vai ser gerado automaticamente
    private String id;

    private String name;

    private float price;

    private Boolean active;

    //relacionando o nosso DTO (RequestProcut) com a entidade Product
    public Product(RequestProduct requestProduct){
        this.name = requestProduct.name();
        this.price = requestProduct.price();
        this.active = true; //set all true when created
    }
}
