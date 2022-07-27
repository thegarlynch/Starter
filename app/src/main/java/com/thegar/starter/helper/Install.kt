package com.thegar.starter.helper

import android.os.Build
import com.appmattus.certificatetransparency.BasicAndroidCTLogger
import com.appmattus.certificatetransparency.installCertificateTransparencyProvider
import com.thegar.starter.BuildConfig
import com.thegar.starter.helper.timber.TimberReleaseTree
import org.conscrypt.Conscrypt
import timber.log.Timber
import java.security.Security

object Install {

    fun timber() {
        val tree = if (BuildConfig.DEBUG) {
            Timber.DebugTree()
        } else {
            TimberReleaseTree()
        }

        Timber.plant(tree)
    }

    /**
     * Add TLS 1.3 for Android SDK < 29 using Conscrypt
     * Use Certificate Transparency
     */
    fun security() {
        if (Build.VERSION.SDK_INT < 29) {
            // don't provide trust manager since it will be
            // provided by CertificateTransparencyProvider below
            val conscrypt = Conscrypt.newProviderBuilder()
                .defaultTlsProtocol("TLSv1.3")
                .provideTrustManager(false)
                .build()

            Security.insertProviderAt(conscrypt, 1)
        }

        installCertificateTransparencyProvider {
            logger = BasicAndroidCTLogger(BuildConfig.DEBUG)
        }
    }
}