package co.edu.unbosque.model;

public interface DataMapper <T, D> {
    D toDTO(T entity);
    T toEntity(D dto);
}
