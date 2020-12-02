package co.edu.uniajc.smartcaf.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniajc.smartcaf.model.Employee;
import co.edu.uniajc.smartcaf.repository.EmployeeRepository;
import co.edu.uniajc.smartcaf.exception.ResourceNotFoundException;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * getAll() Se lista el contenido de la tabla Empleado
	 * 
	 * @return
	 */
	public List<Employee> getAll() {
		List<Employee> listClient = new ArrayList<Employee>();
		try {
			listClient = employeeRepository.findAll();
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return listClient;
	}

	/**
	 * getById Se obtiene por medio de Identificador de tabla Empleado
	 * 
	 * @param idEmployee
	 * @return
	 */
	public Employee getById(Integer idEmployee) {
		Employee usuario = new Employee();
		try {
			if (idEmployee > 0) {
				usuario = employeeRepository.findById(idEmployee).orElseThrow(
						() -> new ResourceNotFoundException("Empleado no encontrado por Id :: " + idEmployee));
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return usuario;
	}

	/**
	 * create Se crea objeto en tabla Empleado
	 * 
	 * @param idUsuario
	 * @return
	 */
	public Employee create(Employee employee) {
		Employee user = new Employee();
		try {
			if (user != null) {
				user = employeeRepository.save(employee);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return user;
	}

	/**
	 * edit Se edita objeto en tabla Empleado
	 * 
	 * @param idEmployee
	 * @return
	 */
	public Employee edit(Integer idEmployee, Employee employeeDetail) {
		Employee user = new Employee();
		try {
			if (idEmployee > 0) {
				Employee client = getById(idEmployee);
				if (client != null) {
					client.setTipoIdentificacion(employeeDetail.getTipoIdentificacion());
					client.setNombres(employeeDetail.getNombres());
					client.setApellidos(employeeDetail.getApellidos());
					client.setTelefono(employeeDetail.getTelefono());
					client.setCorreo(employeeDetail.getCorreo());
					client.setEstado(employeeDetail.getEstado());
					user = employeeRepository.save(client);
				}
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return user;
	}

	/**
	 * delete() Se elimina objeto en tabla Empleado
	 * 
	 * @param idEmployee
	 * @return
	 */
	public void delete(Integer idEmployee) {
		try {
			if (idEmployee > 0) {
				Employee usuario = getById(idEmployee);
				if (usuario != null) {
					employeeRepository.delete(usuario);
				}
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
}
