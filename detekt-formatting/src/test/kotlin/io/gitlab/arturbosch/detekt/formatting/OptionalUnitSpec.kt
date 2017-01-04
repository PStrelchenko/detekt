package io.gitlab.arturbosch.detekt.formatting

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.hasSize
import io.gitlab.arturbosch.detekt.test.format
import io.gitlab.arturbosch.detekt.test.lint
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

/**
 * @author Artur Bosch
 */
class OptionalUnitSpec : Spek({
	describe("running specified rule") {
		it("should detect one finding") {
			val findings = OptionalUnit().lint("""
				fun returnsUnit(): Unit {
				}
			""")
			assertThat(findings, hasSize(equalTo(1)))
		}

		it("should delete Unit return type") {
			val actual = OptionalUnit().format("""
				fun returnsUnit(): Unit {
				}
			""")
			val expected = """
				fun returnsUnit() {
				}
			""".trimIndent()
			assertThat(actual, equalTo(expected))
		}
	}
})