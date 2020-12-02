package co.edu.uniajc.smartcaf.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniajc.smartcaf.model.Client;
import co.edu.uniajc.smartcaf.repository.ClientRepository;
import co.edu.uniajc.smartcaf.exception.ResourceNotFoundException;

@Service
@Transactional
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	/**
	 * getAll() Se lista el contenido de la tabla Cliente
	 * 
	 * @return
	 */
	public List<Client> getAll() {
		List<Client> listClient = new ArrayList<Client>();
		try {
			listClient = clientRepository.findAll();
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return listClient;
	}

	/**
	 * getById Se obtiene por medio de Identificador de tabla Cliente
	 * 
	 * @param idClient
	 * @return
	 */
	public Client getById(Integer idClient) {
		Client usuario = new Client();
		try {
			if (idClient > 0) {
				usuario = clientRepository.findById(idClient).orElseThrow(
						() -> new ResourceNotFoundException("Cliente no encontrado por Id :: " + idClient));
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return usuario;
	}

	/**
	 * create Se crea objeto en tabla Cliente
	 * 
	 * @param idUsuario
	 * @return
	 */
	public Client create(Client client) {
		Client user = new Client();
		try {
			if (user != null) {
				user = clientRepository.save(client);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return user;
	}

	/**
	 * edit Se edita objeto en tabla Cliente
	 * 
	 * @param idClient
	 * @return
	 */
	public Client edit(Integer idClient, Client clientDetail) {
		Client user = new Client();
		try {
			if (idClient > 0) {
				Client client = getById(idClient);
				if (client != null) {
					client.setTipoIdentificacion(clientDetail.getTipoIdentificacion());
					client.setNombres(clientDetail.getNombres());
					client.setApellidos(clientDetail.getApellidos());
					client.setTelefono(clientDetail.getTelefono());
					client.setCorreo(clientDetail.getCorreo());
					client.setMatricula(clientDetail.getMatricula());
					client.setEstado(clientDetail.getEstado());
					user = clientRepository.save(client);
				}
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return user;
	}

	/**
	 * delete() Se elimina objeto en tabla Cliente
	 * 
	 * @param idClient
	 * @return
	 */
	public void delete(Integer idClient) {
		try {
			if (idClient > 0) {
				Client usuario = getById(idClient);
				if (usuario != null) {
					clientRepository.delete(usuario);
				}
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
}
