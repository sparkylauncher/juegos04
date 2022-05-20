package com.sinensia.juegos04.integration.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="VIDEOJUEGOS")
public class Videojuego implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String codigo;
	
	private String titulo;
	
	@Column(name="FECHA_ALTA")
	@Temporal(TemporalType.DATE)
	private Date fechaAlta;
	
	private Double precio;
	private Boolean descatalogado;
	
	@Column(name="TIPO_VIDEOJUEGO")
	@Enumerated(EnumType.STRING)
	private TipoVideojuego tipoVideojuego;
	
	@ManyToOne
	@JoinColumn(name="ID_FABRICANTE")
	private Fabricante fabricante;
	
	public Videojuego() {
		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Boolean getDescatalogado() {
		return descatalogado;
	}

	public void setDescatalogado(Boolean descatalogado) {
		this.descatalogado = descatalogado;
	}

	public TipoVideojuego getTipoVideojuego() {
		return tipoVideojuego;
	}

	public void setTipoVideojuego(TipoVideojuego tipoVideojuego) {
		this.tipoVideojuego = tipoVideojuego;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videojuego other = (Videojuego) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Videojuego [codigo=" + codigo + ", titulo=" + titulo + ", fechaAlta=" + fechaAlta + ", precio=" + precio
				+ ", descatalogado=" + descatalogado + ", tipoVideojuego=" + tipoVideojuego + ", fabricante="
				+ fabricante + "]";
	}

}
