package co.edu.uniajc.smartcaf.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniajc.smartcaf.model.Assistance;
import co.edu.uniajc.smartcaf.repository.AssistanceRepository;
import co.edu.uniajc.smartcaf.exception.ResourceNotFoundException;

@Service
@Transactional
public class AssistanceService {

	@Autowired
	private AssistanceRepository assistance_Repository;

	/**
	 * getAll() Se lista el contenido de la tabla Asistencia
	 * 
	 * @return
	 */
	public List<Assistance> getAll() {
		List<Assistance> listAssistance = new ArrayList<Assistance>();
		try {
			listAssistance = assistance_Repository.findAll();
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return listAssistance;
	}

	/**
	 * getById Se obtiene por medio de Identificador de tabla Asistencia
	 * 
	 * @param idAssitance
	 * @return
	 */
	public Assistance getById(Integer idAssitance) {
		Assistance assistance = new Assistance();
		try {
			if (idAssitance > 0) {
				assistance = assistance_Repository.findById(idAssitance).orElseThrow(
						() -> new ResourceNotFoundException("Usuario no encontrado por Id :: " + idAssitance));
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return assistance;
	}

	/**
	 * create Se crea objeto en tabla Asistencia
	 * 
	 * @param idUsuario
	 * @return
	 */
	public Assistance create(Assistance assistance) {
		Assistance userAssistance = new Assistance();
		try {
			if (userAssistance != null) {
				userAssistance = assistance_Repository.save(assistance);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return userAssistance;
	}

	/**
	 * edit Se edita objeto en tabla Asistencia
	 * 
	 * @param idAssistance
	 * @return
	 */
	public Assistance edit(Integer idAssistance, Assistance assistanceDetail) {
		Assistance user = new Assistance();
		try {
			if (idAssistance > 0) {
				Assistance userAssistance = getById(idAssistance);
				if (userAssistance != null) {
					userAssistance.setFechaEntrada(assistanceDetail.getFechaEntrada());
					userAssistance.setHora(assistanceDetail.getHora());
					userAssistance.setObservacion(assistanceDetail.getObservacion());
					user = assistance_Repository.save(userAssistance);
				}
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return user;
	}

	/**
	 * delete() Se elimina objeto en tabla Asistencia 
	 * 
	 * @param idAssistance
	 * @return
	 */
	public void delete(Integer idAssistance) {
		try {
			if (idAssistance > 0) {
				Assistance assistance = getById(idAssistance);
				if (assistance != null) {
					assistance_Repository.delete(assistance);
				}
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
}
