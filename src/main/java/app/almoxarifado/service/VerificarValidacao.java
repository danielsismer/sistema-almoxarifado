package app.almoxarifado.service;

import app.almoxarifado.model.Fornecedor;
import app.almoxarifado.model.Material;

import java.util.List;

public class VerificarValidacao {

    public static boolean verificarFornecedorExistente(int idFornecedor, List<Fornecedor> fornecedores){

        for(Fornecedor f : fornecedores ){
            if (f.getId() == idFornecedor ){
                return true;
            }
        }

        return false;
    }

    public static boolean verificarMaterialExistente(int idMaterial, List<Material> materiais){
        for (Material m : materiais){
            if (m.getId() == idMaterial) {
                return true;
            }
        }
        return false;
    }

    public static boolean verificarQuantidadeMaterial (int quantidade, int idMaterial, List<Material> materiais){
        for (Material m : materiais){
            if (m.getId() == idMaterial){
                if (quantidade > 0 && quantidade <= m.getEstoque()){
                    return true;
                }
            }
        }
        return false;
    }

}
