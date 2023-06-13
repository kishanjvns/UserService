package com.tech.kj.config.jpa;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO bring this info from redis
		return Optional.of("Kishan");
	}

}
