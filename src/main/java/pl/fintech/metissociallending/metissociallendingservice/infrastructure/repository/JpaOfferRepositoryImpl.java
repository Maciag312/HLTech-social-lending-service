package pl.fintech.metissociallending.metissociallendingservice.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.fintech.metissociallending.metissociallendingservice.domain.lender.Offer;
import pl.fintech.metissociallending.metissociallendingservice.domain.lender.OfferRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class JpaOfferRepositoryImpl implements OfferRepository {

    private final JpaOfferRepo jpaOfferRepo;

    @Override
    public Offer save(Offer offer) {
        return jpaOfferRepo.save(OfferTuple.from(offer)).toDomain();
    }


    @Override
    public List<Offer> findAll() {
        return jpaOfferRepo.findAll().stream().map(OfferTuple::toDomain).collect(Collectors.toList());
    }

    interface  JpaOfferRepo extends JpaRepository<OfferTuple, Long>{
    }

}
