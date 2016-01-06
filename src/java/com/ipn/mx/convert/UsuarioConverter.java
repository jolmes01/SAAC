/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.convert;

import com.ipn.mx.model.dto.Usuario;
import com.ipn.mx.service.UsuarioService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author JL
 */

@FacesConverter("usuarioConverter")
public class UsuarioConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0){
            UsuarioService service = (UsuarioService) fc.getExternalContext().getApplicationMap().get("usuarioService");
            return service.getUsuarios().get(Integer.parseInt(value)-1);
        }else{
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null){
            return String.valueOf(((Usuario) object).getIdUsuario());
        }else{
            return null;
        }
    }
    
}
