<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:if test="${message != null}">
    <div id="message" style="color: red">
        <p>${message}</p>
    </div>
</c:if>

<script>
    setTimeout(function() {
        let message = document.getElementById("message");
        if(message) {
            message.style.display = "none";
        }
    }, 4000)
</script>