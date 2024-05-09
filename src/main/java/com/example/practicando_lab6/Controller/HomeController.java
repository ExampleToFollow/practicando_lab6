package com.example.practicando_lab6.Controller;

import com.example.practicando_lab6.DTO.equiposPorPaisDTO;
import com.example.practicando_lab6.Entity.Device;
import com.example.practicando_lab6.Entity.Technician;
import com.example.practicando_lab6.Repository.*;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    final DeviceRepository deviceRepository;
    final LocationRepository locationRepository;
    final SiteRepository siteRepository;
    final TechnicianRepository technicianRepository;
    final TicketRepository ticketRepository;
    public HomeController( DeviceRepository device,LocationRepository locationRepository ,  SiteRepository siteRepository
            ,TechnicianRepository technicianRepository ,  TicketRepository ticketRepository){
        this.deviceRepository = device;
        this.locationRepository = locationRepository;
        this.siteRepository = siteRepository;
        this.technicianRepository = technicianRepository;
        this.ticketRepository = ticketRepository;
    }


    @GetMapping("/Home")
    public String hola() {
        return "index";
    }
    @GetMapping("/TecnicosList")
    public String TecnicosList(Model model) {
        model.addAttribute("listaTecnicos",(technicianRepository.findAll()));
        for(Technician t :(technicianRepository.findAll())){
            System.out.println(t.getFirstName());
        }
        System.out.println("TecnicosList");
        return "listaTecnicos";
    }
    @GetMapping("/createTech")
    public String CreateTechnician(Model model , @ModelAttribute("technician") Technician tech){
        return "EditCreateTechnician";
    }
    @PostMapping("/createTechCompleted")
    public String CreateTechnicianCompleted(Model model, @ModelAttribute("technician") @Valid Technician technician ,
                                            BindingResult bindingResult, RedirectAttributes attr){
        if(!bindingResult.hasErrors()) {
            if (!(technician.getTechnicianId() == 0)) {
                attr.addFlashAttribute("msg", "Tecnico" + technician.getFirstName() + " " + technician.getLastName() + "fue actualizado   exitosamente ");
                technicianRepository.save(technician);

            } else {
                Technician tech = technicianRepository.save(technician);
                attr.addFlashAttribute("msg", "Tecnico" + tech.getFirstName() + " " + tech.getLastName() + "fue creado exitosamente ");
            }
            technicianRepository.save(technician);
            return "redirect:/TecnicosList";
        }else{
            System.out.println("HUBO ERRORES D:");
            return "EditCreateTechnician";
        }
    }

    @GetMapping("/EditTech")
    public String EditTechnician(Model model , @ModelAttribute("technician") Technician technician , @RequestParam("id") int idTech){
        Optional<Technician> techAux = technicianRepository.findById(idTech);
        if(techAux.isPresent()){
            technician = techAux.get();
            model.addAttribute("technician", technician);
            System.out.println(technician.getFirstName());
        }
        return "EditCreateTechnician";
    }

    @GetMapping("/EstadisticasList")
    public String EstadisticasList(Model model) {
        System.out.println("EstadisticasList");
        List<equiposPorPaisDTO> lista = deviceRepository.getEquiposPorPaisDTO();
        model.addAttribute("lista" , lista);
        return "Estadisticas";
    }


}
