package com.kodgemisi.blog.multilanguage;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on May, 2019
 *
 * @author ersan
 */
@Data
@Embeddable
@NoArgsConstructor
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
class MultiLanguageText implements Serializable {

	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb")
	private Map<String, String> texts = new HashMap<>();

	MultiLanguageText(Map<String, String> texts) {
		this.texts = texts;
	}

	@Override
	public String toString() {
		return texts.getOrDefault(Languages.getDefaultLanguage(), "");
	}

}
