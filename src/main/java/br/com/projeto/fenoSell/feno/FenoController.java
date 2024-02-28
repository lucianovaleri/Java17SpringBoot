package br.com.projeto.fenoSell.feno;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.fenoSell.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class FenoController {
    
    @Autowired
    private IFenoRepository fenoRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody FenoModel fenoModel, HttpServletRequest request){
        var idUser = request.getAttribute("idUser");
        fenoModel.setIdUser((UUID) idUser);

        var currentDate = LocalDateTime.now();
        if(currentDate.isBefore(fenoModel.getDataCorte())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("A data de corte precisa ser anterior ao anúncio");
        }

        if(fenoModel.getTitulo() == null || fenoModel.getTitulo().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("Todo anúncio precisa de um título");
        }

        if(fenoModel.getPreço() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("Todo anúncio precisa de um preço");
        }

        var feno = this.fenoRepository.save(fenoModel);
        return ResponseEntity.status(HttpStatus.OK).body(feno);
    }

    @GetMapping("/")
    public List<FenoModel> list(HttpServletRequest request){
        var idUser = request.getAttribute("idUser");
        var tasks = this.fenoRepository.findByIdUser((UUID) idUser);
        return tasks;
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody FenoModel fenoModel, HttpServletRequest request, @PathVariable UUID id){        
        var feno = this.fenoRepository.findById(id).orElse(null); 
        
        if(feno == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Feno não encontrada");
        }
        
        var idUser = request.getAttribute("idUser");

        if(!feno.getIdUser().equals(idUser)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário não tem permissão para alterar esse Feno");
        }

        Utils.copyNonNullProperties(fenoModel, feno);

        var taskUpdated = this.fenoRepository.save(feno);

        return ResponseEntity.ok().body(taskUpdated);
    }

}
