package co.edu.uniajc.smartcaf.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniajc.smartcaf.model.PhysicalEvaluation;
import co.edu.uniajc.smartcaf.repository.PhysicalEvaluationRepository;
import co.edu.uniajc.smartcaf.exception.ResourceNotFoundException;

@Service
@Transactional
public class PhysicalEvalutionService {

	@Autowired
	private PhysicalEvaluationRepository physicalEvaluationRepository;

	/**
	 * getAll() Se lista el contenido de la tabla Asistencia
	 * 
	 * @return
	 */
	public List<PhysicalEvaluation> getAll() {
		List<PhysicalEvaluation> listPhysicalEvaluation = new ArrayList<PhysicalEvaluation>();
		try {
			listPhysicalEvaluation = physicalEvaluationRepository.findAll();
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return listPhysicalEvaluation;
	}

	/**
	 * getById Se obtiene por medio de Identificador de tabla Asistencia
	 * 
	 * @param idPhysicalEvaluation
	 * @return
	 */
	public PhysicalEvaluation getById(Integer idPhysicalEvaluation) {
		PhysicalEvaluation assistance = new PhysicalEvaluation();
		try {
			if (idPhysicalEvaluation > 0) {
				assistance = physicalEvaluationRepository.findById(idPhysicalEvaluation).orElseThrow(
						() -> new ResourceNotFoundException("Evaluacion fisica no encontrado por Id :: " + idPhysicalEvaluation));
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return assistance;
	}

	/**
	 * create Se crea objeto en tabla Asistencia
	 * 
	 * @return
	 */
	public PhysicalEvaluation create(PhysicalEvaluation physicalEvaluation) {
		PhysicalEvaluation userAssistance = new PhysicalEvaluation();
		try {
			if (userAssistance != null) {
				userAssistance = physicalEvaluationRepository.save(physicalEvaluation);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return userAssistance;
	}

	/**
	 * edit Se edita objeto en tabla Asistencia
	 * 
	 * @param idPhysicalEvaluation
	 * @return
	 */
	public PhysicalEvaluation edit(Integer idPhysicalEvaluation, PhysicalEvaluation physicalEvaluationDetail) {
		PhysicalEvaluation physicalEvaluation = new PhysicalEvaluation();
		try {
			if (idPhysicalEvaluation > 0) {
				PhysicalEvaluation userEvaluation = getById(idPhysicalEvaluation);
				if (userEvaluation != null) {
					userEvaluation.setFechaRegistro(physicalEvaluationDetail.getFechaRegistro());
					userEvaluation.setHora(physicalEvaluationDetail.getHora());
					userEvaluation.setLesionesFisicas(physicalEvaluationDetail.getLesionesFisicas());
					userEvaluation.setConsumoMedicamentos(physicalEvaluationDetail.getConsumoMedicamentos());
					userEvaluation.setConsumoSustanciasPsicoactivas(physicalEvaluationDetail.getConsumoSustanciasPsicoactivas());
					userEvaluation.setHoraSueno(physicalEvaluationDetail.getHoraSueno());
					userEvaluation.setAltura(physicalEvaluationDetail.getAltura());
					userEvaluation.setPulso(physicalEvaluationDetail.getPulso());
					userEvaluation.setObservacion(physicalEvaluationDetail.getObservacion());
					physicalEvaluation = physicalEvaluationRepository.save(userEvaluation);
				}
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return physicalEvaluation;
	}

	/**
	 * delete() Se elimina objeto en tabla Asistencia 
	 * 
	 * @param idPhysicalEvaluation
	 * @return
	 */
	public void delete(Integer idPhysicalEvaluation) {
		try {
			if (idPhysicalEvaluation > 0) {
				PhysicalEvaluation physicalEvaluation = getById(idPhysicalEvaluation);
				if (physicalEvaluation != null) {
					physicalEvaluationRepository.delete(physicalEvaluation);
				}
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
}
