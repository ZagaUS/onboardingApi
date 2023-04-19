package com.zaga.employee_onboarding;

import java.io.IOException;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongoCmdOptions;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.IFeatureAwareVersion;
import de.flapdoodle.embed.mongo.distribution.Version;

@TestConfiguration
public class EmbeddedMongoConfiguration {

    @Bean
    public MongodConfig mongodConfig() throws IOException {

        Net net = new Net(27017, false);
        IFeatureAwareVersion version = Version.Main.V5_0;

        MongoCmdOptions cmdOptions = MongoCmdOptions.builder().useNoJournal(false).build();
        MongodConfig mongodConfig = MongodConfig.builder()
                .stopTimeoutInMillis(120000L)
                .net(net)
                .cmdOptions(cmdOptions)
                .version(version)
                .build();
        return mongodConfig;
    }
}
