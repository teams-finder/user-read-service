package com.teamsfinder.userreadservice.user.exception;

import java.time.LocalDateTime;

record ErroResponse(
        String httpStatus,
        String message,
        LocalDateTime localDateTime) {

}
