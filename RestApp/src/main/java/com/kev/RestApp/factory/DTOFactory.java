package com.kev.RestApp.factory;

import com.kev.RestApp.entity.Simulation;
import com.kev.RestApp.entity.User;
import com.kev.RestApp.simulation.SimulationDTO;
import com.kev.RestApp.user.UserDTO;
import com.kev.RestApp.user.UserRepository;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class DTOFactory {

    private final UserRepository userRepository;

    public DTOFactory(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserDTO createDTO(User user) {
        //Needs try and catch with return createDTOWithoutSimulation(user);
        UserDTO userDTO =
                new UserDTO(
                        user.getUserId(),
                        user.getEmail());
        return userDTO;
    }

    public SimulationDTO createDTO(Simulation simulation) {

        if (simulation == null)
        {
            return null;
        }

        SimulationDTO simulationDTO =
                new SimulationDTO(
                        simulation.getSimulationId(),
                        simulation.getLastInput(),
//                        simulation.getUser().toString(),
                        simulation.getAgeAircraft(),
                        simulation.getNoOfPassengers(),
                        simulation.getPicLicence(),
                        simulation.getPicAge(),
                        simulation.getTotalHrs(),
                        simulation.getTypeHrs(),
                        simulation.getNinetyDayHrs(),
                        simulation.getTwentyEightDayHrs(),
                        simulation.getDayOfWeek(),
                        simulation.getAccidentSeverity(),
                        simulation.getInjurySeverity());
        return simulationDTO;
    }

    public SimulationDTO updateDTO(Simulation simulation) {
        if (simulation == null) {
            return null;
        }

        SimulationDTO simulationDTO =
                new SimulationDTO(
                        simulation.getSimulationId(),
                        simulation.getLastInput(),
                        simulation.getAgeAircraft(),
                        simulation.getNoOfPassengers(),
                        simulation.getPicLicence(),
                        simulation.getPicAge(),
                        simulation.getTotalHrs(),
                        simulation.getTypeHrs(),
                        simulation.getNinetyDayHrs(),
                        simulation.getTwentyEightDayHrs(),
                        simulation.getDayOfWeek(),
                        simulation.getAccidentSeverity(),
                        simulation.getInjurySeverity());

        return simulationDTO;
    }


}
