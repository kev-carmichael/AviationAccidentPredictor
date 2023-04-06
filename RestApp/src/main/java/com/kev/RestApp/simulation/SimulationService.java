package com.kev.RestApp.simulation;

import com.kev.RestApp.entity.Simulation;
import com.kev.RestApp.factory.DTOFactory;

import java.util.ArrayList;
import java.util.List;

public class SimulationService {

    private DTOFactory dtoFactory;
    private final SimulationRepository simulationRepository;

    public List<SimulationDTO> getSimulationList(){
        List<SimulationDTO> list = new ArrayList<>();
        for (Simulation simulation : simulationRepository.findAll()){
            SimulationDTO simulationDTO = dtoFactory.createDTO(simulation);
            list.add(simulationDTO);
        }
        return list;
    }

}