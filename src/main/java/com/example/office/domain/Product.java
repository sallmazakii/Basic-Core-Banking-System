package com.example.office.domain;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name= "s_Product")
    public class Product {
        @Id
        @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
        private Long id;

        @Column
        private String name;

        @Column
        private Long noRepaymentMin;

        @Column
        private Long noRepaymentMax;

        @Column
        private Long principalMin;

        @Column
        private Long principalMax;

        @Column
        private Long commission;

        @Column
        private Long fees;

    public static Product createProduct (ProductDTO productDTO){
         return Product.builder()
                .name(productDTO.getName())
                .noRepaymentMin(productDTO.getNoRepaymentMin())
                .noRepaymentMax(productDTO.getNoRepaymentMax())
                .principalMin(productDTO.getPrincipalMin())
                .principalMax(productDTO.getPrincipalMax())
                .commission(productDTO.getCommission())
                .fees(productDTO.getFees())
                .build();
    }
    public static Product updateProduct (ProductDTO productDTO, Product product ) {
        product.setName(productDTO.getName());
        product.setNoRepaymentMin(productDTO.getNoRepaymentMin());
        product.setNoRepaymentMax(productDTO.getNoRepaymentMax());
        product.setPrincipalMin(productDTO.getPrincipalMin());
        product.setPrincipalMax(productDTO.getPrincipalMax());
        product.setCommission(productDTO.getCommission());
        product.setFees(productDTO.getFees());
        return  product;

    }
}
