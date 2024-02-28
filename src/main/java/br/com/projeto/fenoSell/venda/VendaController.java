package br.com.projeto.fenoSell.venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.projeto.fenoSell.user.UserModel;

public class VendaController {
    
    @Autowired
    private IVendaRepository vendaRepository;

    @PostMapping("/")
    public ResponseEntity vender(@RequestBody VendaModel vendaModel) {

    if (vendaModel.getQuantidade() == null) {
         return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("Precisa adicionar a quantidade");
    } 

    if (vendaModel.getFeno().getPreço() == null && vendaModel.getValores() == null) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body("O Feno selecionado está sem preço, você precisa adicionar o valor da venda");
    }
    
    var venda = this.vendaRepository.save(vendaModel);
    return ResponseEntity.status(HttpStatus.OK).body(venda);

}

}
