package com.thegar.starter.helper.timber

import timber.log.Timber

class TimberReleaseTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        // no-op
    }
}
