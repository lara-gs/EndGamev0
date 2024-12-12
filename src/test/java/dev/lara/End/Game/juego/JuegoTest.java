package dev.lara.End.Game.juego;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dev.lara.End.Game.config.LoginRequest;
import dev.lara.End.Game.config.LoginResponse;
import dev.lara.End.Game.controllers.AuthController;
import dev.lara.End.Game.controllers.HistoriaController;
import dev.lara.End.Game.controllers.OpcionesController;
import dev.lara.End.Game.controllers.ProgresoController;
import dev.lara.End.Game.controllers.RolController;
import dev.lara.End.Game.controllers.UsuarioController;
import dev.lara.End.Game.dtos.HistoriaDTO;
import dev.lara.End.Game.dtos.OpcionesDTO;
import dev.lara.End.Game.dtos.ProgresoDTO;
import dev.lara.End.Game.dtos.RolDTO;
import dev.lara.End.Game.dtos.UsuarioDTO;
import dev.lara.End.Game.juego.Manager.ServiceManager;

class JuegoTest {

    @Mock
    private AuthController authController;

    @Mock
    private HistoriaController historiaController;

    @Mock
    private OpcionesController opcionesController;

    @Mock
    private ProgresoController progresoController;

    @Mock
    private RolController rolController;

    @Mock
    private UsuarioController userController;

    @Mock
    private ServiceManager serviceManager;

    @InjectMocks
    private Juego juego;

    private UsuarioDTO mockUser;
    private ProgresoDTO mockProgreso;
    private List<HistoriaDTO> mockHistorias;
    private List<OpcionesDTO> mockOpciones;
    private RolDTO mockRol;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        mockRol = new RolDTO(2, "USER");
        mockUser = new UsuarioDTO(1, "Test User", "test@example.com", mockRol, "password");
        mockProgreso = new ProgresoDTO(1, 1, 1, LocalDate.now(), "1,2");
        mockHistorias = new ArrayList<>();
        mockHistorias.add(new HistoriaDTO(1, "Historia 1"));
        mockOpciones = new ArrayList<>();
        mockOpciones.add(new OpcionesDTO(1, 1, 2, 1, 2, "Opcion 1", false, 0));

        
        when(serviceManager.login(any(LoginRequest.class))).thenReturn(new LoginResponse("Login exitoso", "hola@hola.com", mockUser));
        when(serviceManager.cargarPartida(mockUser.getIdUsuario())).thenReturn(mockProgreso);
        when(serviceManager.cargarHistorias()).thenReturn(mockHistorias);
        when(serviceManager.cargarOpciones(mockProgreso.getIdHistoria())).thenReturn(mockOpciones);
    }

    @Test
    void testIniciarSesion_SuccessfulLogin() {
        
        LoginRequest loginRequest = new LoginRequest("test@example.com", "password");
        LoginResponse loginResponse = serviceManager.login(loginRequest);

        assertNotNull(loginResponse);
        assertEquals("Login exitoso", loginResponse.getMessage());
        assertEquals(mockUser.getCorreo(), loginResponse.getUsuarioDTO().getCorreo());
    }

    @Test
    void testRegistrarUsuario_SuccessfulRegistration() {
        when(serviceManager.registerUser(any(UsuarioDTO.class))).thenReturn(mockUser);

        UsuarioDTO newUser = new UsuarioDTO(1, "Test User", "test@example.com", mockRol, "password");
        UsuarioDTO registeredUser = serviceManager.registerUser(newUser);

        assertNotNull(registeredUser);
        assertEquals(newUser.getCorreo(), registeredUser.getCorreo());
    }

    @Test
    void testCargarProgreso_SuccessfulLoad() {
        ProgresoDTO progreso = serviceManager.cargarPartida(mockUser.getIdUsuario());

        assertNotNull(progreso);
        assertEquals(mockProgreso.getIdProgreso(), progreso.getIdProgreso());
    }

    @Test
    void testCargarHistorias_SuccessfulLoad() {
        List<HistoriaDTO> historias = serviceManager.cargarHistorias();

        assertNotNull(historias);
        assertEquals(1, historias.size());
        assertEquals("Historia 1", historias.get(0).getDescripcion());
    }

    @Test
    void testCargarOpciones_SuccessfulLoad() {
        List<OpcionesDTO> opciones = serviceManager.cargarOpciones(mockProgreso.getIdHistoria());

        assertNotNull(opciones);
        assertEquals(1, opciones.size());
        assertEquals("Opcion 1", opciones.get(0).getDescripcion());
    }
}
