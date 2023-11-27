/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;

/**
 *
 * @author anhta
 */
public abstract class QLKS <E, K> {
    abstract  public void insert(E e);
    abstract  public void update(E e);
    abstract  public void delete(K id);
    abstract  public E selectById (K id);
    abstract  public List<E> selectAll();
    abstract protected List<E> selectBySql(String sql, Object... args);
}
