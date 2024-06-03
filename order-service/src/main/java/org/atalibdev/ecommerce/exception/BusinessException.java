package org.atalibdev.ecommerce.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Almousleck on May, 2024
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException{
    private final  String msg;
}
