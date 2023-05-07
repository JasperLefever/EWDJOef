package domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter @Setter
public class Price {
    
    //private Integer percentIncrease;
    //+ getter en setter
    
    //drie @ 
    //het moet ingevuld zijn - foutboodschap wordt overschreven (zonder sleutel)
    //moet minstens 1 zijn - foutboodschap overschrijven (met sleutel)
    //hoogtens 50 - foutboodschap wordt overschreven (zonder sleutel)
    //foutboodschap NumberFormatException wordt overschreven
    
    @NotNull
    @Min(value = 1, message = "{price.percentIncrease.Min.message}")
    @Max(50)
    private Integer percentIncrease;

    //private Integer percentDecrease;
    //twee @
    //het moet ingevuld zijn - foutboodschap wordt overschreven (zonder sleutel)
    //het moet liggen tussen 1 en 25 - foutboodschap overschrijven (met sleutel)
    //foutboodschap NumberFormatException wordt overschreven

    @NotNull
    @Range(min = 1, max = 25, message = "{price.percentDecrease.Range.message}")
    private Integer percentDecrease;
}
