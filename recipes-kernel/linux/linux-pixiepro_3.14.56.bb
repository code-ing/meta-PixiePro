DESCRIPTION = "Linux kernel for CODE PixiePro board"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SRC_URI = "git://github.com/code-ing/linux-fslc.git;protocol=git;branch=3.14-1.0.x-mx6-PixiePro-patches"
SRCREV = "3.14-1.0.x-mx6-PixiePro-patches"

DEPENDS += "lzop-native bc-native"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "(pixiepro)"

LINUX_VERSION ?= "3.14.56"

KERNEL_IMAGETYPE = "zImage"

KERNEL_DEFCONFIG = "pixiepro_defconfig"


do_configure_prepend() {
        install -m 0644 ${S}/arch/${ARCH}/configs/${KERNEL_DEFCONFIG} ${WORKDIR}/defconfig || die "No default configuration for ${MACHINE} / ${KERNEL_DEFCONFIG} available."
}