package com.alexcruceat.ServicioProductos;

import com.alexcruceat.ServicioProductos.dto.SolicitudProducto;
import com.alexcruceat.ServicioProductos.repository.RepositorioProducto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ServicioProductosApplicationTests {

	//Mapeador de Objectos, en este caso lo usamos para mapear un objeto a un JSON.
	@Autowired
	private ObjectMapper oMP;

	//Utilizado para hacer requests
	@Autowired
	private MockMvc mMVC;

	//Contenedor del MongoDB en la versión 5.0.8
	@Container
	static MongoDBContainer mDBC = new MongoDBContainer("mongo:5.0");

	@Autowired
	private RepositorioProducto repoProducto;

	//Establecemos las propiedades a un registro de propiedades dinámico.
	@DynamicPropertySource
	static void establecerPropiedades(DynamicPropertyRegistry registro){
		//Establecemos la URI del mongodb
		registro.add("spring.data.mongodb.uri",mDBC::getReplicaSetUrl);
	}
	@Test
	void deberiaCrearProducto() throws Exception {

		//Creamos un objeto de tipo SolicitudObjeto
		SolicitudProducto solicitudProducto = obtenerSolicitudProducto();

		//Mapeamos el objeto a un JSON.
		String JSON = oMP.writeValueAsString(solicitudProducto);

		//Hacemos una petición post a la API de productos para crear el producto.
		//Y comprobamos que se haya creado.
		mMVC.perform(MockMvcRequestBuilders.post("/api/producto")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JSON)
		).andExpect(status().isCreated());

        Assertions.assertEquals(1, repoProducto.findAll().size());
	}

	/**
	 * Crea una objeto de tipo {@link SolicitudProducto} para los tests.
	 * @return Objeto de tipo {@link SolicitudProducto}
	 */
	private SolicitudProducto obtenerSolicitudProducto() {
		return SolicitudProducto.builder()
				.nombre("Iphone 10")
				.descripcion("Iphone 10")
				.precio(BigDecimal.valueOf(400))
				.build();
	}

}
