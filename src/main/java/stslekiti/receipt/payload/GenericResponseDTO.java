package stslekiti.receipt.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class GenericResponseDTO {

    private String code;
    @JsonIgnore
    private HttpStatus status;
    private String message;
    private Object data;
    private Map<String, String> metadata;

    public GenericResponseDTO() {
    }

    public GenericResponseDTO(String code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public GenericResponseDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public GenericResponseDTO(String code, HttpStatus status, String message, Object data) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public GenericResponseDTO(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public GenericResponseDTO(String code, HttpStatus status, String message, Object data, Map<String, String> metadata) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.data = data;
        this.metadata = metadata;
    }

    public GenericResponseDTO(String code, String message, Object data, Map<String, String> metadata) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.metadata = metadata;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "GenericResponseDTO{" +
                "code='" + code + '\'' +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", metadata=" + metadata +
                '}';
    }
}
