package com.aewinformatica.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.aewinformatica.erp.model.Empresa;
import com.aewinformatica.erp.model.RamoAtividade;
import com.aewinformatica.erp.model.TipoEmpresa;
import com.aewinformatica.erp.repository.Empresas;
import com.aewinformatica.erp.repository.RamoAtividades;
import com.aewinformatica.erp.util.FacesMessages;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Empresas empresas;
	
	@Inject
	private FacesMessages messages;
	
    @Inject
    private RamoAtividades ramoAtividades;
    
    private Converter ramoAtividadeConverter;
	


	private List<Empresa>listaEmpresas;
	
	private String termoPesquisa;
	
	public void pesquisar() {
		listaEmpresas = empresas.pesquisar(termoPesquisa);
		
		if(listaEmpresas.isEmpty()) {
			messages.info("Sua consulta nao retornou registros.");
		}
	}
	public void todasEmpresas() {
		
		this.listaEmpresas = empresas.todas();
	}
	
    public List<RamoAtividade> completarRamoAtividade(String termo) {
        List<RamoAtividade> listaRamoAtividades = ramoAtividades.pesquisar(termo);
        
        ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividades);
        
        return listaRamoAtividades;
    }


	public Converter getRamoAtividadeConverter() {
		return ramoAtividadeConverter;
	}
	public void setRamoAtividadeConverter(Converter ramoAtividadeConverter) {
		this.ramoAtividadeConverter = ramoAtividadeConverter;
	}
	
	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}


	public String getTermoPesquisa() {
		return termoPesquisa;
	}


	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}

	public TipoEmpresa[] getTiposEmpresa() {
		
		return TipoEmpresa.values();
	}
	
}
