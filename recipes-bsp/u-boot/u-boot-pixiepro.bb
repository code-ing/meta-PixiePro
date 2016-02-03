# Copyright (C) 2013-2015 Freescale Semiconductor

DESCRIPTION = "U-Boot for CODE PixiePro Board"

require recipes-bsp/u-boot/u-boot.inc

inherit fsl-u-boot-localversion

COMPATIBLE_MACHINE = "(pixiepro)"

DEPENDS_mxs += "elftosb-native openssl-native"

PROVIDES += "u-boot"

SRC_URI = "git://github.com/code-ing/u-boot-fslc-PixiePro.git;protocol=git;branch=${SRCREV}"
SRCREV = "patches-2015.04"

S = "${WORKDIR}/git"

# FIXME: Allow linking of 'tools' binaries with native libraries
#        used for generating the boot logo and other tools used
#        during the build process.
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CPPFLAGS}" \
                 HOSTLDFLAGS="${BUILD_LDFLAGS}" \
                 HOSTSTRIP=true'


