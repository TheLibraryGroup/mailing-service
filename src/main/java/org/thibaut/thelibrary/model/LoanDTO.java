package org.thibaut.thelibrary.model;

import lombok.*;
import org.joda.time.DateTime;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoanDTO implements Serializable {

	private Long id;

	private boolean returned = false;
	private DateTime startDate;
	private DateTime initialEndDate;
	private DateTime extendedEndDate;

	private Long bookId;

	private Long userId;
	private String email;


}
