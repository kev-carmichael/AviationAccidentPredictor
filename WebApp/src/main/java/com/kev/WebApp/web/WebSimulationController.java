package com.kev.WebApp.web;

import com.kev.WebApp.DTO.*;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebSimulationController {
    ArrayList<String> simulationData = new ArrayList<>();

    @GetMapping(path = "/web/simulation/start")
    public String selectSimulationType() {
        return "index";
    }

    @GetMapping(path = "/web/simulation/run8")
    public String runSimulation8(Model model) {
        model.addAttribute("simulationInput", new SimulationInput());
        return "enter8values";
    }

    @GetMapping(path = "/web/simulation/run9")
    public String runSimulation9(Model model) {
        model.addAttribute("simulationInput", new SimulationInput());
        return "enter9values";
    }

    @PostMapping(path = "/web/simulation/run8")
    public String runSimulation8(@ModelAttribute SimulationInput simulationInput, Model model) {
        LocalDateTime lastInput = LocalDateTime.now();
        SimulationInputDTO simulationInputDTO = new SimulationInputDTO(
                lastInput.toString(),
                Integer.parseInt(simulationInput.getText0()),
                Integer.parseInt(simulationInput.getText1()),
                simulationInput.getText2(),
                Integer.parseInt(simulationInput.getText3()),
                Integer.parseInt(simulationInput.getText4()),
                Integer.parseInt(simulationInput.getText5()),
                Integer.parseInt(simulationInput.getText6()),
                Integer.parseInt(simulationInput.getText7()),
                null);

        SimulationDTO simulationDTO =
                new RestTemplateBuilder()
                        .build()
                        .postForObject(
                                "http://localhost:8080/rest/simulation/run8",
                                simulationInputDTO,
                                SimulationDTO.class);

        model.addAttribute(
                "simulationResult",
                new SimulationResult(simulationInput.getText2(), simulationDTO.getAccidentSeverity()));

        return "result";
    }

    @PostMapping(path = "/web/simulation/run9")
    public String runSimulation9(@ModelAttribute SimulationInput simulationInput, Model model) {
        LocalDateTime lastInput = LocalDateTime.now();
        SimulationInputDTO simulationInputDTO = new SimulationInputDTO(
                lastInput.toString(),
                Integer.parseInt(simulationInput.getText0()),
                Integer.parseInt(simulationInput.getText1()),
                simulationInput.getText2(),
                Integer.parseInt(simulationInput.getText3()),
                Integer.parseInt(simulationInput.getText4()),
                Integer.parseInt(simulationInput.getText5()),
                Integer.parseInt(simulationInput.getText6()),
                Integer.parseInt(simulationInput.getText7()),
                simulationInput.getText8());

        SimulationDTO simulationDTO =
                new RestTemplateBuilder()
                        .build()
                        .postForObject(
                                "http://localhost:8080/rest/simulation/run9",
                                simulationInputDTO,
                                SimulationDTO.class);

        model.addAttribute(
                "simulationResult",
                new SimulationResult(simulationInput.getText2(), simulationDTO.getInjurySeverity()));

        return "result";
    }

    @GetMapping(path = "/web/simulation/all")
    public String getSimulationList(Model model) {

        SimulationDTOList response = new RestTemplateBuilder()
                .build()
                .getForObject(
                        "http://localhost:8080/rest/simulation/all",
                        SimulationDTOList.class);

        List<SimulationDTO> list = response.getList();
            model.addAttribute(
                    "kevCollection", list);

        return "all";
    }

    @GetMapping(path = "/web/user/all") //PUT IN OWN WEBUSERCONTROLLER CLASS
    public String getUserList(Model model) {

        UserDTOList response = new RestTemplateBuilder()
                .build()
                .getForObject(
                        "http://localhost:8080/rest/user/all",
                        UserDTOList.class);

        List<UserDTO> list = response.getList();
        String listString = "";
        for (UserDTO userDTO : list) {
            listString += userDTO.toString();
        }
        model.addAttribute(
                "simulationResult",
                new SimulationResult("", listString));

        return "userlist";
    }


}
