package co.edu.uniajc.smartcaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.uniajc.smartcaf.model.PhysicalEvaluation;

@Repository
public interface PhysicalEvaluationRepository extends JpaRepository<PhysicalEvaluation, Integer> {
}

