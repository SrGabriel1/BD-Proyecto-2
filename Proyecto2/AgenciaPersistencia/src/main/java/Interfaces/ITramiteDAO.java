/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Tramite;
import java.util.List;

/**
 *
 * @author yohan
 */
public interface ITramiteDAO {

    public List<Tramite> Consulta(String RFC) throws Exception;
    
//    public List<Tramite>
}
