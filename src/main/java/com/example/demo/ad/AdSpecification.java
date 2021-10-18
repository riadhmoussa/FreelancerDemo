package com.example.demo.ad;

import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class AdSpecification  implements Specification {
    private final Ad ad;

    public AdSpecification(Ad ad) {
        this.ad = ad;
    }

    @Override
    public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
        // It would also be possible to chain the ".equal" methods with ".and" or ".notNull"
        return criteriaBuilder.or(
                criteriaBuilder.equal(root.get("id"), this.ad.getId()),
                criteriaBuilder.equal(root.get("nom"), this.ad.getNom()),
                criteriaBuilder.equal(root.get("description"), this.ad.getNom()),
                criteriaBuilder.equal(root.get("prix"), this.ad.getNom()),
                criteriaBuilder.equal(root.get("categorie"), this.ad.getNom())
        );
    }

    @Override
    public Specification and(Specification other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification or(Specification other) {
        return Specification.super.or(other);
    }
}
